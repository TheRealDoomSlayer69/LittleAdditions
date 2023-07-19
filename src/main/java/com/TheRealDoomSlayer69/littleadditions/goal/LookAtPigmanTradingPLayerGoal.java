package com.TheRealDoomSlayer69.littleadditions.entity.goal;

import com.TheRealDoomSlayer69.littleadditions.entity.abstratc.AbstractPigman;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;

public class LookAtPigmanTradingPLayerGoal  extends LookAtPlayerGoal {
    private final AbstractPigman pigman;

    public LookAtPigmanTradingPLayerGoal(AbstractPigman pPigman) {
        super(pPigman, Player.class, 8.0F);
        this.pigman = pPigman;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        if (this.pigman.isTrading()) {
            this.lookAt = this.pigman.getTradingPlayer();
            return true;
        } else {
            return false;
        }
    }
}
