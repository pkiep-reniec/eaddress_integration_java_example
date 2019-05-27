<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>RENIEC eAddress - Example JAVA</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="text-center">Domicilio Electrónico - RENIEC</h1>
            <h4 class="text-center">Send Result</h4>

            <div class="col-sm-12">
                <p><b>MENSAJE:</b> ${response}</p>
            </div>
        </div>

        <div class="col-sm-12 text-center">
            <a href="${baseUrl}/" class="btn btn-danger">Enviar Nuevo</a>
        </div>
    </div>
</div>
</body>
</html>
