package com.TheRealDoomSlayer69.littleadditions.entity.goal;

import com.TheRealDoomSlayer69.littleadditions.entity.abstratc.AbstractPigman;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class PigmanTradeWithPlayerGoal extends Goal {

    private final AbstractPigman mob;

    public PigmanTradeWithPlayerGoal(AbstractPigman pMob) {
        this.mob = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        if (!this.mob.isAlive()) {
            return false;
        } else if (this.mob.isInWater()) {
            return false;
        } else if (!this.mob.isOnGround()) {
            return false;
        } else if (this.mob.hurtMarked) {
            return false;
        } else {
            Player player = this.mob.getTradingPlayer();
            if (player == null) {
                return false;
            } else if (this.mob.distanceToSqr(player) > 16.0D) {
                return false;
            } else {
                return player.containerMenu != null;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.mob.getNavigation().stop();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.mob.setTradingPlayer((Player)null);
    }
}
