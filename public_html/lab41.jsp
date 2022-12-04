<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 4-3</title>
</head>
<body>
    <form method="get" action="/java112/Lab41Servlet">
        <label for="first_name" >First Name</label>
        <input type="text" id="first_name" name="first_name"  />
        <br><br>
        <label for="last_name" >Last Name</label>
        <input type="text" id="last_name" name="last_name"  />
        <br><br>
        <div>
            <label for="test1">Test 1</label>
            <input type="radio" id="test1" name="test" value="test1">
            <label for="test2">Test 2</label>
            <input type="radio" id="test2" name="test" value="test2">
            <label for="test3">Test 3</label>
            <input type="radio" id="test3" name="test" value="test3">
        </div>
        <br><br>
        <div>
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</body>
</html>