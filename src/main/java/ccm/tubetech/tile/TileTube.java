package ccm.tubetech.tile;

import ccm.tubetech.util.EnumSymbol;
import com.sun.javafx.sg.prism.PrismMediaFrameHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

public class TileTube extends TileEntity
{
    private EnumSymbol symbol = EnumSymbol.values()[new Random().nextInt(EnumSymbol.values().length)];
    private boolean    state = new Random().nextBoolean();

    public TileTube()
    {
        super();
    }

    public TileTube(World world)
    {
        super();
        setWorldObj(world);
    }

    public EnumSymbol getSymbol()
    {
        return symbol;
    }

    public ResourceLocation getTexture()
    {
        return this.getSymbol().getTexture(getState());
    }

    public boolean getState()
    {
        return state;
    }

    public boolean click(EntityPlayer player)
    {
        state = !state;

        return false;
    }
}
