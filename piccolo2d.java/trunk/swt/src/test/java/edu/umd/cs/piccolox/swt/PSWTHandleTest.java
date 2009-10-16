package edu.umd.cs.piccolox.swt;

import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolo.event.PInputEventListener;
import edu.umd.cs.piccolox.util.PBoundsLocator;
import edu.umd.cs.piccolox.util.PLocator;

public class PSWTHandleTest extends SWTTest {
    private PNode node;
    private PSWTHandle handle;
    private PBoundsLocator locator;

    public void setUp() throws Exception {
        if (hasHead()) {
            node = new PNode();
            locator = PBoundsLocator.createEastLocator(node);
            handle = new PSWTHandle(locator);
            node.setBounds(0, 0, 100, 100);
            node.addChild(handle);
        }
    }

    public void testDefaultsAreCorrect() {
        if (hasHead()) {
            assertEquals(PSWTHandle.DEFAULT_COLOR, handle.getPaint());
            assertEquals(PSWTHandle.DEFAULT_HANDLE_SIZE + 2 /** for border pen */
            , handle.getHeight(), Float.MIN_VALUE);
        }
    }

    public void testLocatorPersists() {
        if (hasHead()) {
            assertSame(locator, handle.getLocator());

            PLocator newLocator = PBoundsLocator.createWestLocator(node);
            handle.setLocator(newLocator);
            assertSame(newLocator, handle.getLocator());
        }
    }

    public void testHandleHasDragHandlerInstalled() {
        if (hasHead()) {
            PInputEventListener dragHandler = handle.getHandleDraggerHandler();
            assertNotNull(dragHandler);

            PInputEventListener[] installedListeners = handle.getInputEventListeners();
            assertEquals(1, installedListeners.length);
            assertSame(dragHandler, installedListeners[0]);
        }
    }

    public void testChangingParentDoesNotChangeLocatorNode() {
        if (hasHead()) {
            handle.relocateHandle();
            PNode newParent = new PNode();
            newParent.setBounds(50, 50, 100, 100);

            final double originalX = handle.getX();
            handle.setParent(newParent);

            final double newX = handle.getX();

            assertEquals(newX, originalX, Double.MIN_VALUE);
        }
    }
}