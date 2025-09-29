<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Початок квесту</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 100px;
            text-align: center;
        }
        h1 {
            color: #007bff;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }
        a:hover {
            background-color: #0056b3;
        }
        p {
            font-size: 18px;
            color: #343a40;
            line-height: 1.5;
            overflow-wrap: break-word;
            hyphens: auto;
        }
        @media (min-width: 992px) {
            .container {
                max-width: 1140px;
            }
        }
        @media (min-width: 1200px) {
            .container {
                max-width: 1320px;
            }
        }
        .row {
            margin-left: -1px;
            margin-right: -1px;
        }
        .col-md-4 {
            padding-left: 60px;
            padding-right: 60px;
            margin-bottom: 60px;
            display: grid;
        }
    </style>
</head>
<body>
<div class="container">
    <h1><%= "Ласкаво просимо в захоплюючий світ пригод!" %>
        <br>
        <%= "Ти опинився в захоплюючому місці, де кожен вибір визначає твою долю." %>
    </h1>
    <div class="row justify-content-center text-justify">
        <div class="col-md-5 text-center">
            <br>
            <br>
            <h4>
                Загадка НЛО
            </h4>
            <br>
            <p>
                Втрачаючи пам'ять, Ви знаходитесь в епіцентрі неймовірної пригоди.
                Перед Вами стоїть вибір - прийняти виклик НЛО, чи відмовитися. Ваша відповідь визначить долю героя.
            </p>
            <p>
                Піднявшись на місток, Вас чекає питання про Вашу ідентичність. Чи розкриєте Ви правду?
                Кожен вибір веде до виграшу, чи програшу, впливаючи на кінцевий результат цього захоплюючого
                квесту.
            </p>
            <br/>
            <a href="quest-servlet?type=ufo">Почати квест</a>
        </div>
    </div>
</div>
</body>
