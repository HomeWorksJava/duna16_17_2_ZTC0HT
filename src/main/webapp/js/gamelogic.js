var gameTableStatus;

window.onload = function (){
    var currentGameId = getParameterByName('gameId');
    if(currentGameId == null){
        createNewGame();
    }else {
        gameTableStatus = getGameStatusObject(currentGameId);
        document.getElementById("currentGame").innerHTML += " ("+currentGameId + ")";
        if(gameTableStatus !== null) {
            for (i = 0; i < gameTableStatus.gameField.length; i++) {
                for (j = 0; j < gameTableStatus.gameField[i].length; j++) {
                    document.getElementById("" + i + "_" + j).value = getField(i, j);
                }
            }
        }
    }
}

function isHorizontalWin() {
    for (i = 0; i < gameTableStatus.gameField.length; i++) {
        if(gameTableStatus.gameField[i][0] !== ""){
            if(gameTableStatus.gameField[i][0] === gameTableStatus.gameField[i][1] && gameTableStatus.gameField[i][1]  === gameTableStatus.gameField[i][2]){
                return true;
            }
        }
    }
    return false;
}

function isVerticalWin() {
    for (i = 0; i < gameTableStatus.gameField.length; i++) {
        if(gameTableStatus.gameField[0][i] !== ""){
            if(gameTableStatus.gameField[0][i] === gameTableStatus.gameField[1][i] && gameTableStatus.gameField[1][i]  === gameTableStatus.gameField[2][i]){
                return true;
            }
        }
    }
    return false;
}

function isDiagonalWin() {
    if(gameTableStatus.gameField[1][1] !== ""){
        return (gameTableStatus.gameField[0][0] === gameTableStatus.gameField[1][1] && gameTableStatus.gameField[1][1] === gameTableStatus.gameField[2][2] ) ||
               (gameTableStatus.gameField[2][0] === gameTableStatus.gameField[1][1] && gameTableStatus.gameField[1][1] === gameTableStatus.gameField[0][2] )
    }else{
        return false;
    }

}
function isGameDraw() {
    for (i = 0; i < gameTableStatus.gameField.length; i++) {
        for (j = 0; j < gameTableStatus.gameField[i].length; j++) {
            if(gameTableStatus.gameField[i][j] === "") {
                return false;
            }
        }
    }
    return true;
}

function isGameOver(){
    return isHorizontalWin() || isVerticalWin() || isDiagonalWin() || isGameDraw();
}

function fieldSelected(cordinate, ordinate) {
    if(getField(cordinate, ordinate) === "") {
        gameTableStatus.gameField[cordinate][ordinate] = gameTableStatus.currPlayer;
        if (gameTableStatus.currPlayer === 'X') {
            gameTableStatus.currPlayer = 'O';
        } else {
            gameTableStatus.currPlayer = 'X';
        }
        saveGameField(cordinate, ordinate, gameTableStatus.currPlayer);
        if(isGameOver()){
            alert("Game is Over!");
        }
    }
}

function loadGame(){
    window.location.href = '/ticktacktoe/game?gameId=' + document.getElementById("gameChanger").value;
}

function getGameStatusObject(currentGameId){
    var gameStatusJsonInString = getGameStatus(currentGameId);
    if(gameStatusJsonInString === ""){
        createNewGame();
    }else {
        var gameStatusJsonObject = JSON.parse(gameStatusJsonInString);
        return gameStatusJsonObject;
    }
}

function getField(cordinate, ordinate) {
    return gameTableStatus.gameField[cordinate][ordinate];
}

function saveGameField(cordinate, ordinate, player) {
    document.getElementById("" + cordinate + "_" + ordinate).value = getField(cordinate,ordinate);
    saveGame(gameTableStatus);
}

function getGameStatus(currentGameId)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/ticktacktoe/rest/game/status?gameId=" + currentGameId, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}


function saveGame(gameTableStatus) {
    var xmlHttp = new XMLHttpRequest();
    var gameTableStatusInJson = JSON.stringify(gameTableStatus);
    xmlHttp.open( "POST", "/ticktacktoe/rest/game/savegame?gameId="+ getParameterByName('gameId'), false ); // false for synchronous request
    xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send( gameTableStatusInJson );
}

function createNewGame(){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", "/ticktacktoe/rest/game/newgame", false ); // false for synchronous request
    xmlHttp.send( null );
    var gameId = xmlHttp.responseText;
    window.location.href = '/ticktacktoe/game?gameId=' + gameId;
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}