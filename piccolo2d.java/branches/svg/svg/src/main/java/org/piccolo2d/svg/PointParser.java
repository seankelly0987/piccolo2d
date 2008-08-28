// line 1 "src/main/ragel/PointParser.rl"
/*
 * Copyright (c) 2008, Piccolo2D project, http://piccolo2d.org
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * None of the name of the Piccolo2D project, the University of Maryland, or the names of its contributors
 * may be used to endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.piccolo2d.svg;

import java.awt.geom.GeneralPath;
import java.text.ParseException;

/** <a href="http://research.cs.queensu.ca/~thurston/ragel/">Ragel> parser 
 * for <a href="http://www.w3.org/TR/SVG11/shapes.html#PointsBNF">list of points</a> - This file is auto-generated by rl2java.sh.
 * <p>
 * DO NOT EDIT MANUALLY!!!
 * </p>
 */
class PointParser {
// line 91 "src/main/ragel/PointParser.rl"



// line 46 "src/main/java/org/piccolo2d/svg/PointParser.java"
private static byte[] init__points_actions_0()
{
	return new byte [] {
	    0,    1,    0,    1,    1,    1,    2,    2,    0,    1,    2,    2,
	    3,    2,    2,    4
	};
}

private static final byte _points_actions[] = init__points_actions_0();


private static short[] init__points_key_offsets_0()
{
	return new short [] {
	    0,    0,    3,    5,   13,   22,   25,   27,   30,   32,   40,   49,
	   52,   54,   62,   71,   79,   83,   85,   89,   91,   97,  101,  103,
	  111,  115,  117,  123,  132,  140,  148,  157,  165,  174,  180,  186
	};
}

private static final short _points_key_offsets[] = init__points_key_offsets_0();


private static char[] init__points_trans_keys_0()
{
	return new char [] {
	   46,   48,   57,   48,   57,   32,   44,   69,  101,    9,   13,   48,
	   57,   32,   44,   46,    9,   13,   43,   45,   48,   57,   46,   48,
	   57,   48,   57,   46,   48,   57,   48,   57,   32,   44,   69,  101,
	    9,   13,   48,   57,   32,   44,   46,    9,   13,   43,   45,   48,
	   57,   46,   48,   57,   48,   57,   32,   43,   45,   46,    9,   13,
	   48,   57,   32,   44,   46,   69,  101,    9,   13,   48,   57,   32,
	   43,   45,   46,    9,   13,   48,   57,   43,   45,   48,   57,   48,
	   57,   43,   45,   48,   57,   48,   57,   32,   44,    9,   13,   48,
	   57,   43,   45,   48,   57,   48,   57,   32,   43,   45,   46,    9,
	   13,   48,   57,   43,   45,   48,   57,   48,   57,   32,   44,    9,
	   13,   48,   57,   32,   44,   46,   69,  101,    9,   13,   48,   57,
	   32,   43,   45,   46,    9,   13,   48,   57,   32,   44,   69,  101,
	    9,   13,   48,   57,   32,   44,   46,    9,   13,   43,   45,   48,
	   57,   32,   44,   69,  101,    9,   13,   48,   57,   32,   44,   46,
	   69,  101,    9,   13,   48,   57,   32,   44,    9,   13,   48,   57,
	   32,   44,    9,   13,   48,   57,   32,   44,   46,   69,  101,    9,
	   13,   48,   57,    0
	};
}

private static final char _points_trans_keys[] = init__points_trans_keys_0();


private static byte[] init__points_single_lengths_0()
{
	return new byte [] {
	    0,    1,    0,    4,    3,    1,    0,    1,    0,    4,    3,    1,
	    0,    4,    5,    4,    2,    0,    2,    0,    2,    2,    0,    4,
	    2,    0,    2,    5,    4,    4,    3,    4,    5,    2,    2,    5
	};
}

private static final byte _points_single_lengths[] = init__points_single_lengths_0();


private static byte[] init__points_range_lengths_0()
{
	return new byte [] {
	    0,    1,    1,    2,    3,    1,    1,    1,    1,    2,    3,    1,
	    1,    2,    2,    2,    1,    1,    1,    1,    2,    1,    1,    2,
	    1,    1,    2,    2,    2,    2,    3,    2,    2,    2,    2,    2
	};
}

private static final byte _points_range_lengths[] = init__points_range_lengths_0();


private static short[] init__points_index_offsets_0()
{
	return new short [] {
	    0,    0,    3,    5,   12,   19,   22,   24,   27,   29,   36,   43,
	   46,   48,   55,   63,   70,   74,   76,   80,   82,   87,   91,   93,
	  100,  104,  106,  111,  119,  126,  133,  140,  147,  155,  160,  165
	};
}

private static final short _points_index_offsets[] = init__points_index_offsets_0();


private static byte[] init__points_indicies_0()
{
	return new byte [] {
	    0,    2,    1,    3,    1,    4,    5,    6,    6,    4,    3,    1,
	    7,    9,   10,    7,    8,   11,    1,   10,   11,    1,   12,    1,
	   13,   14,    1,   15,    1,   16,   17,   18,   18,   16,   15,    1,
	   19,   21,   22,   19,   20,   23,    1,   22,   23,    1,   24,    1,
	   25,   26,   26,   27,   25,   28,    1,   16,   17,   15,   18,   18,
	   16,   14,    1,   21,   20,   20,   22,   21,   23,    1,   29,   29,
	   30,    1,   30,    1,   31,   31,   32,    1,   32,    1,   16,   17,
	   16,   32,    1,   33,   33,   34,    1,   34,    1,    9,    8,    8,
	   10,    9,   11,    1,   35,   35,   36,    1,   36,    1,    4,    5,
	    4,   36,    1,    4,    5,    3,    6,    6,    4,    2,    1,   37,
	   38,   38,   39,   37,   40,    1,   41,   42,   43,   43,   41,   12,
	    1,   44,   25,   27,   44,   26,   28,    1,   45,   46,   47,   47,
	   45,   24,    1,   45,   46,   24,   47,   47,   45,   23,    1,   45,
	   46,   45,   30,    1,   41,   42,   41,   34,    1,   41,   42,   12,
	   43,   43,   41,   11,    1,    0
	};
}

private static final byte _points_indicies[] = init__points_indicies_0();


private static byte[] init__points_trans_targs_0()
{
	return new byte [] {
	    2,    0,   27,    3,    4,   23,   24,    4,    5,   23,    6,   35,
	   29,    8,   14,    9,   10,   15,   18,   10,   11,   15,   12,   32,
	   31,   13,    7,    8,   14,   17,   33,   19,   20,   22,   34,   25,
	   26,   28,    1,    2,   27,   30,   13,   21,   30,   30,   13,   16
	};
}

private static final byte _points_trans_targs[] = init__points_trans_targs_0();


private static byte[] init__points_trans_actions_0()
{
	return new byte [] {
	    0,    0,    3,    3,    5,    5,    0,    0,    3,    0,    0,    3,
	    3,    0,    3,    3,    5,    5,    0,    0,    3,    0,    0,    3,
	    3,    0,    7,    1,    7,    0,    3,    0,    3,    0,    3,    0,
	    3,    0,    7,    1,    7,   10,   10,    0,    0,   13,   13,    0
	};
}

private static final byte _points_trans_actions[] = init__points_trans_actions_0();


private static byte[] init__points_eof_actions_0()
{
	return new byte [] {
	    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
	    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
	    0,    0,    0,    0,    0,   10,    0,   13,   13,   13,   10,   10
	};
}

private static final byte _points_eof_actions[] = init__points_eof_actions_0();


static final int points_start = 28;
static final int points_first_final = 28;
static final int points_error = 0;

static final int points_en_main = 28;

// line 94 "src/main/ragel/PointParser.rl"

	final GeneralPath parse(final CharSequence data) throws ParseException {
		return parse(data == null ? null : data.toString().toCharArray());
	}

	final GeneralPath parse(final char[] data) throws ParseException {
		final GeneralPath gp = new GeneralPath();
		if(data == null)
			return gp;
		// high-level buffers
		final StringBuilder buf = new StringBuilder();
		final float[] argv = new float[2];
		int argc = 0;
		
		// ragel variables (low level)
		final int pe = data.length;
		final int eof = pe;
		int cs, p = 0;
		int top;

		
// line 222 "src/main/java/org/piccolo2d/svg/PointParser.java"
	{
	cs = points_start;
	}
// line 115 "src/main/ragel/PointParser.rl"
		
// line 228 "src/main/java/org/piccolo2d/svg/PointParser.java"
	{
	int _klen;
	int _trans = 0;
	int _acts;
	int _nacts;
	int _keys;
	int _goto_targ = 0;

	_goto: while (true) {
	switch ( _goto_targ ) {
	case 0:
	if ( p == pe ) {
		_goto_targ = 4;
		continue _goto;
	}
	if ( cs == 0 ) {
		_goto_targ = 5;
		continue _goto;
	}
case 1:
	_match: do {
	_keys = _points_key_offsets[cs];
	_trans = _points_index_offsets[cs];
	_klen = _points_single_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + _klen - 1;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + ((_upper-_lower) >> 1);
			if ( data[p] < _points_trans_keys[_mid] )
				_upper = _mid - 1;
			else if ( data[p] > _points_trans_keys[_mid] )
				_lower = _mid + 1;
			else {
				_trans += (_mid - _keys);
				break _match;
			}
		}
		_keys += _klen;
		_trans += _klen;
	}

	_klen = _points_range_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + (_klen<<1) - 2;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + (((_upper-_lower) >> 1) & ~1);
			if ( data[p] < _points_trans_keys[_mid] )
				_upper = _mid - 2;
			else if ( data[p] > _points_trans_keys[_mid+1] )
				_lower = _mid + 2;
			else {
				_trans += ((_mid - _keys)>>1);
				break _match;
			}
		}
		_trans += _klen;
	}
	} while (false);

	_trans = _points_indicies[_trans];
	cs = _points_trans_targs[_trans];

	if ( _points_trans_actions[_trans] != 0 ) {
		_acts = _points_trans_actions[_trans];
		_nacts = (int) _points_actions[_acts++];
		while ( _nacts-- > 0 )
	{
			switch ( _points_actions[_acts++] )
			{
	case 0:
// line 48 "src/main/ragel/PointParser.rl"
	{
		argc = 0;
	}
	break;
	case 1:
// line 52 "src/main/ragel/PointParser.rl"
	{
		buf.append(data[p]);
	}
	break;
	case 2:
// line 56 "src/main/ragel/PointParser.rl"
	{
		argv[argc++] = Float.parseFloat(buf.toString());
		buf.setLength(0);
	}
	break;
	case 3:
// line 61 "src/main/ragel/PointParser.rl"
	{
		gp.moveTo(argv[0], argv[1]);
		argc = 0;
	}
	break;
	case 4:
// line 66 "src/main/ragel/PointParser.rl"
	{
		gp.lineTo(argv[0], argv[1]);
		argc = 0;
	}
	break;
// line 341 "src/main/java/org/piccolo2d/svg/PointParser.java"
			}
		}
	}

case 2:
	if ( cs == 0 ) {
		_goto_targ = 5;
		continue _goto;
	}
	if ( ++p != pe ) {
		_goto_targ = 1;
		continue _goto;
	}
case 4:
	if ( p == eof )
	{
	int __acts = _points_eof_actions[cs];
	int __nacts = (int) _points_actions[__acts++];
	while ( __nacts-- > 0 ) {
		switch ( _points_actions[__acts++] ) {
	case 2:
// line 56 "src/main/ragel/PointParser.rl"
	{
		argv[argc++] = Float.parseFloat(buf.toString());
		buf.setLength(0);
	}
	break;
	case 3:
// line 61 "src/main/ragel/PointParser.rl"
	{
		gp.moveTo(argv[0], argv[1]);
		argc = 0;
	}
	break;
	case 4:
// line 66 "src/main/ragel/PointParser.rl"
	{
		gp.lineTo(argv[0], argv[1]);
		argc = 0;
	}
	break;
// line 383 "src/main/java/org/piccolo2d/svg/PointParser.java"
		}
	}
	}

case 5:
	}
	break; }
	}
// line 116 "src/main/ragel/PointParser.rl"

		if ( cs < points_first_final )
			throw new ParseException(new String(data), p);
        return gp;
	}
}
