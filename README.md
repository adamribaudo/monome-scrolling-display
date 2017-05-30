# monome-scrolling-display

Processing sketch that turns the monome into a scrolling LED display. Receives OSC data in the form of:

/mtn/note [note value] [velocity] [channel number]

Note that [velocity] must be >0 (note off commands are ignored)

# Dependencies
- Monome Processing https://github.com/monome/monome-processing
- OscP5 http://www.sojamo.de/libraries/oscP5/
