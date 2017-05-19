<!DOCTYPE html>
<html>
<head>
    <link href="/ticktacktoe/css/game.css" rel="stylesheet" type="text/css">
    <script src="/ticktacktoe/js/gamelogic.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="center">
        <table class="centered">
            <tr>
                <td><input id="0_0" class='transparent-field' type='button' onclick="fieldSelected(0,0)"/></td>
                <td><input id="0_1" class='transparent-field' type='button' onclick="fieldSelected(0,1)"/></td>
                <td><input id="0_2" class='transparent-field' type='button' onclick="fieldSelected(0,2)"/></td>
            </tr>
            <tr>
                <td><input id="1_0" class='transparent-field' type='button' onclick="fieldSelected(1,0)"/></td>
                <td><input id="1_1" class='transparent-field' type='button' onclick="fieldSelected(1,1)"/></td>
                <td><input id="1_2" class='transparent-field' type='button' onclick="fieldSelected(1,2)"/></td>
            </tr>
            <tr>
                <td><input id="2_0" class='transparent-field' type='button' onclick="fieldSelected(2,0)"/></td>
                <td><input id="2_1" class='transparent-field' type='button' onclick="fieldSelected(2,1)"/></td>
                <td><input id="2_2" class='transparent-field' type='button' onclick="fieldSelected(2,2)"/></td>
            </tr>
        </table>
    </div>
    <div class="center">
        <button onclick="createNewGame()"> NEW GAME</button>

        <div class="center">
            <p id="currentGame">Change Game</p>
        </div>
        <div class="center">
            <input id="gameChanger" type="number" onchange="loadGame()">
        </div>
    </div>
</body>
</html>