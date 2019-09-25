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
            <h4 class="text-center">JAVA Example Integration</h4>

            <form action="home" method="POST">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" placeholder="DNI" required>
                </div>
                <div class="form-group">
                    <label for="subject">ASUNTO</label>
                    <input type="text" class="form-control" id="subject" name="subject" placeholder="ASUNTO" required>
                </div>
                <div class="form-group">
                    <label for="tag">TAG</label>
                    <input type="text" class="form-control" id="tag" name="tag" placeholder="TAG">
                </div>
                <div class="form-group form-check">
                    <label for="tag">MENSAJE</label>
                    <textarea class="form-control" id="message" name="message" rows="4" placeholder="MENSAJE" required>
                    </textarea>
                </div>

                <div class="col-sm-12 text-center">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <%--<a href="home" class="btn btn-success">Ingresar</a>--%>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
