package com.ticktacktoe.game.web;

import com.ticktacktoe.game.services.api.GameStatusService;
import com.ticktacktoe.game.web.domain.GameStatusViewModel;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/game")
@Api(value = "Game")
@Singleton
public class GameController {

    @Inject
    GameStatusService gameStatusService;

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public GameStatusViewModel getGameStatus(@QueryParam("gameId") Integer gameId){
        try {
            return gameStatusService.getById(gameId);
        } catch (NoResultException exception){
            return null;
        }
    }

    @POST
    @Path("/newgame")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Integer createNewGame(){
           return gameStatusService.createNewGame();
    }

    @POST
    @Path("/savegame")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void savegame(@QueryParam("gameId") Integer gameId, GameStatusViewModel gameStatusViewModel){
        gameStatusService.saveGame(gameId, gameStatusViewModel);
    }
}
