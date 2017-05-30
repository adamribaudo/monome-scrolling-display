# monome-scrolling-display

Processing sketch that turns the monome into a scrolling LED display. Receives OSC data from an Ableton Max4Live device in the form of

/mtn/note [note value] [velocity] [channel number]

*Note that [velocity] must be >0 (note off commands are ignored)

The Processing sketch in this repository is strucured to be used in Eclipse, not the Processing IDE. Read more here: https://processing.org/tutorials/eclipse/

# Dependencies
- Monome Processing https://github.com/monome/monome-processing
- OscP5 http://www.sojamo.de/libraries/oscP5/
- Max4Live Device that converts MIDI data into OSC data mtn.oscFromMidi.amxd
- Ableton Live
