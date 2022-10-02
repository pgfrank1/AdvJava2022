# Changes made for review 2

FileAnalysis:
    1) Reduced the testForOneArgument method length to return true or false.
    2) Changed passUserFile to only do one action.
    3) splitUserFileText now only splits the current line of text and sends the
            result to a new method sendTokenForProcessing.
    4) The newly added sendTokenForProcessing method loops through the argument
            and ensures that the current singular token has a length.
            
