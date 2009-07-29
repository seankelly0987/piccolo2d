package edu.umd.cs.piccolo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import edu.umd.cs.piccolo.util.PBounds;

public class PLayerTest extends TestCase {
    private PLayer layer;

    public void setUp() {
        layer = new PLayer();
    }

    public void testLayerHasEmptyCamerasCollectionByDefault() {
        final Collection cameras = layer.getCamerasReference();
        assertNotNull(cameras);
        assertTrue(cameras.isEmpty());
        assertEquals(0, layer.getCameraCount());
    }

    public void testGetCameraByIndexThrowsIndexOutOfBoundsExceptionWhenOutOfBounds() {
        final PCamera camera = new PCamera();
        layer.addCamera(camera);
        try {
            layer.getCamera(-1);
            fail("Exception should have been thrown");
        }
        catch (final IndexOutOfBoundsException e) {
            // expected;
        }

        try {
            layer.getCamera(1);
            fail("Exception should have been thrown");
        }
        catch (final IndexOutOfBoundsException e) {
            // expected;
        }
    }

    public void testGetCameraReturnsCameraAtCorrectIndex() {
        final PCamera camera1 = new PCamera();
        final PCamera camera2 = new PCamera();
        final PCamera camera3 = new PCamera();

        layer.addCamera(camera1);
        layer.addCamera(camera2);
        layer.addCamera(camera3);

        assertEquals(camera1, layer.getCamera(0));
        assertEquals(camera2, layer.getCamera(1));
        assertEquals(camera3, layer.getCamera(2));
    }

    public void testAddCameraCorrectlyHandlesIndex() {
        final PCamera camera1 = new PCamera();
        final PCamera camera2 = new PCamera();
        final PCamera camera3 = new PCamera();

        layer.addCamera(0, camera1);
        layer.addCamera(0, camera2);
        layer.addCamera(1, camera3);

        assertEquals(camera2, layer.getCamera(0));
        assertEquals(camera3, layer.getCamera(1));
        assertEquals(camera1, layer.getCamera(2));
    }

    public void testRemovingCameraByReferenceWorksWhenCameraIsFound() {
        final PCamera camera = new PCamera();
        layer.addCamera(camera);
        layer.removeCamera(camera);
        assertEquals(0, layer.getCameraCount());
    }

    public void testRemovingCameraByIndexWorksWhenIndexIsValid() {
        final PCamera camera = new PCamera();
        layer.addCamera(camera);
        layer.removeCamera(0);
        assertEquals(0, layer.getCameraCount());
    }

    public void testRemovingCameraNotAttachedToCameraShouldDoNothing() {
        final PCamera strangerCamera = new PCamera();
        layer.removeCamera(strangerCamera);
        assertEquals(0, layer.getCameraCount());
    }

    public void testRepaintFromNotifiesCameras() {
        final MockPCamera camera = new MockPCamera();
        layer.addCamera(camera);

        final PBounds bounds = new PBounds(0, 0, 100, 100);
        layer.repaintFrom(bounds, layer);

        assertEquals(1, camera.notifications.size());

        final MockPCamera.Notification notification = (MockPCamera.Notification) camera.notifications.get(0);
        assertEquals(layer, notification.layer);
        assertEquals(bounds, notification.bounds);
    }

    static class MockPCamera extends PCamera {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        List notifications = new ArrayList();

        public void repaintFromLayer(final PBounds bounds, final PLayer layer) {
            notifications.add(new Notification("repaintFromLayer", bounds, layer));
            super.repaintFromLayer(bounds, layer);
        }

        class Notification {
            String type;
            PBounds bounds;
            // this should really be PLayer
            PNode layer;

            Notification(final String type, final PBounds bounds, final PNode layer) {
                this.bounds = bounds;
                this.layer = layer;
                this.type = type;
            }
        }

    }
}