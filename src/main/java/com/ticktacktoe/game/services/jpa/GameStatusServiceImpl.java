package com.ticktacktoe.game.services.jpa;

import com.ticktacktoe.game.datamodel.GameStatus;
import com.ticktacktoe.game.services.GenericDaoServiceImpl;
import com.ticktacktoe.game.services.api.GameStatusService;
import com.ticktacktoe.game.web.domain.GameStatusViewModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashMap;

@RequestScoped
@Transactional
public class GameStatusServiceImpl implements GameStatusService {

    @Inject
    GenericDaoServiceImpl dao;

    @Override
    public GameStatusViewModel getById(Integer id) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("id", id);
        GameStatus gameStatus = (GameStatus)dao.getEntity("GameStatus.findById", params);

        String[][] gameTable = new String[3][3];
        gameTable[0][0] = gameStatus.getRow0_col0();
        gameTable[0][1] = gameStatus.getRow0_col1();
        gameTable[0][2] = gameStatus.getRow0_col2();

        gameTable[1][0] = gameStatus.getRow1_col0();
        gameTable[1][1] = gameStatus.getRow1_col1();
        gameTable[1][2] = gameStatus.getRow1_col2();

        gameTable[2][0] = gameStatus.getRow2_col0();
        gameTable[2][1] = gameStatus.getRow2_col1();
        gameTable[2][2] = gameStatus.getRow2_col2();

        GameStatusViewModel gameStatusViewModel = new GameStatusViewModel();
        gameStatusViewModel.setCurrPlayer(gameStatus.getActivePlayer());
        gameStatusViewModel.setGameField(gameTable);
        return gameStatusViewModel;
    }

    @Override
    public Integer createNewGame() {
        GameStatus gameStatus = new GameStatus();
        gameStatus.setRow0_col0("");
        gameStatus.setRow0_col1("");
        gameStatus.setRow0_col2("");

        gameStatus.setRow1_col0("");
       gameStatus.setRow1_col1("");
        gameStatus.setRow1_col2("");

        gameStatus.setRow2_col0("");
        gameStatus.setRow2_col1("");
         gameStatus.setRow2_col2("");

        gameStatus.setActivePlayer("X");
        return  ((GameStatus)dao.save(gameStatus)).getId();
    }

    @Override
    public void saveGame(Integer gameId, GameStatusViewModel gameStatusViewModel) {
        GameStatus gameStatus = new GameStatus();
        gameStatus.setId(gameId);
        gameStatus.setActivePlayer(gameStatusViewModel.getCurrPlayer());

        gameStatus.setRow0_col0(gameStatusViewModel.getGameField()[0][0]);
        gameStatus.setRow0_col1(gameStatusViewModel.getGameField()[0][1]);
        gameStatus.setRow0_col2(gameStatusViewModel.getGameField()[0][2]);

        gameStatus.setRow1_col0(gameStatusViewModel.getGameField()[1][0]);
        gameStatus.setRow1_col1(gameStatusViewModel.getGameField()[1][1]);
        gameStatus.setRow1_col2(gameStatusViewModel.getGameField()[1][2]);

        gameStatus.setRow2_col0(gameStatusViewModel.getGameField()[2][0]);
        gameStatus.setRow2_col1(gameStatusViewModel.getGameField()[2][1]);
        gameStatus.setRow2_col2(gameStatusViewModel.getGameField()[2][2]);
        dao.save(gameStatus);
    }
}
