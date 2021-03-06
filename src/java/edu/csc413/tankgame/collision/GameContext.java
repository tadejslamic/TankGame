package edu.csc413.tankgame.collision;

import edu.csc413.tankgame.model.*;

import java.util.List;

public class GameContext {
    private CollisionHandler handler;

    public GameContext(){

    }

    public void executeCollision(Entity entity1, Entity entity2, List<Entity> removeList){
        handler = new TankTankCollisionHandler();
        if (entity1 instanceof Tank && entity2 instanceof Tank) {
            handler = new TankTankCollisionHandler();
        } else if (entity1 instanceof Shell && entity2 instanceof Shell) {
            handler = new ShellShellCollisionHandler();
        } else if (entity1 instanceof Tank && entity2 instanceof Shell) {
            handler = new TankShellCollisionHandler();
        } else if (entity1 instanceof Shell && entity2 instanceof Tank) {
            handler = new TankShellCollisionHandler();
        } else if (entity1 instanceof Tank && entity2 instanceof Wall) {
            handler = new TankWallCollisionHandler();
        } else if (entity1 instanceof Wall && entity2 instanceof Tank) {
            handler = new TankWallCollisionHandler();
        } else if (entity1 instanceof Wall && entity2 instanceof Shell) {
            handler = new ShellWallCollisionHandler();
        } else if (entity1 instanceof Shell && entity2 instanceof Wall) {
            handler = new ShellWallCollisionHandler();
        } else if (entity1 instanceof PowerUp && entity2 instanceof PlayerTank) {
            handler = new TankPowerUpCollisionHandler();
        } else if (entity1 instanceof PlayerTank && entity2 instanceof PowerUp) {
            handler = new TankPowerUpCollisionHandler();
        } else if( entity1 instanceof PowerUp || entity2 instanceof PowerUp ) {
            return;
        }

        handler.handleCollision(entity1, entity2, removeList);
    }
}
