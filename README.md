# monome-scrolling-display

Processing sketch that turns the monome into a scrolling LED display. Receives OSC data from an Ableton Max4Live device in the form of

/mtn/note [note value] [velocity] [channel number]

*Note that [velocity] must be >0 (note off commands are ignored)

The Processing sketch in this repository is strucured to be used in Eclipse, not the Processing IDE. Read more here: https://processing.org/tutorials/eclipse/. 

# Instructions

1. Open Ableton Live, connect Monome Grid, and launch the Processing sketch
2. Add the M4L device to a MIDI track (mtn.oscFromMidi.amxd)
3. Create a MIDI clip. G#-0 notes advance the scrolling display 1 column to the left. Notes below that draw on the screen.
4. Play the clip. You should see lights display on the Monome and on your screen.

# Dependencies
- Monome Processing https://github.com/monome/monome-processing
- OscP5 http://www.sojamo.de/libraries/oscP5/
- Max4Live Device that converts MIDI data into OSC data (included in root of repo as mtn.oscFromMidi.amxd)
- Ableton Live
- SerialOSC https://github.com/monome/serialosc/releases

# Exmaples

![Monom Scrolling Display](/example.gif)

- https://vimeo.com/219413987
