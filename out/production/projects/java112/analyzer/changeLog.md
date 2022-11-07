# Changes made for review 2


<ul>
    <li>FileAnalysis:</li>
    <ol>
        <li>Reduced the testForOneArgument method length to return true or false.</li>
        <li>Changed passUserFile to only do one action.</li>
        <li>splitUserFileText now only splits the current line of text and sends the result to a new method sendTokenForProcessing.</li>
        <li>The newly added sendTokenForProcessing method loops through the argument and ensures that the current singular token has a length.</li>
    </ol>
    <li>FileSummaryAnalyzer:</li>
    <ol><li>Reduced the processToken method to only increment for each token.</li></ol>
    <li>DistinctTokensAnalyzer:</li>
    <ol><li>Reduced the processToken method to only add new words to the set.</li></ol>
</ul>