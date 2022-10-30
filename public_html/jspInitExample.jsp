<%!
    private String initMethodString;

    public String getInitMethodString() {
        return initMethodString;
    }
    public void jspInit() {
        // Your code goes here
        initMethodString = "I'm text from the jspInit method!";
    }

%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jspInit Example</title>
</head>
<body>
    <h4><%= getInitMethodString() %></h4>
</body>
</html>