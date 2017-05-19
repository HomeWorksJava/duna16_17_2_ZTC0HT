package com.ticktacktoe.game.services.api;

import com.ticktacktoe.game.web.domain.GameStatusViewModel;

public interface GameStatusService {

    GameStatusViewModel getById(Integer id);

    Integer createNewGame();

    void saveGame(Integer gameId, GameStatusViewModel gameStatusViewModel);
}
