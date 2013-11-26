package ccm.tubetech;

import static ccm.tubetech.util.Data.*;

import ccm.tubetech.Render.TubeRenderer;
import ccm.tubetech.block.BlockTube;
import ccm.tubetech.tile.TileTube;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@Mod(modid = MODID, name = MODID)
public class TubeTech
{
    @Mod.Instance(MODID)
    private static TubeTech instance;

    private BlockTube blockTube;
    private TubeTechConfig config;

    public static TubeTech getInstance()
    {
        return instance;
    }

    @Mod.EventHandler
    public void fmlEvent(FMLPreInitializationEvent event)
    {
        config = new TubeTechConfig(event);

        blockTube = new BlockTube(config.BLOCKID_TUBE);
        GameRegistry.registerBlock(blockTube, "tube");
        LanguageRegistry.addName(blockTube, "Tube");
        GameRegistry.registerTileEntity(TileTube.class, MODID + "tube");

        if (event.getSide().isClient())
        {
            ClientRegistry.bindTileEntitySpecialRenderer(TileTube.class, new TubeRenderer());
        }
    }
}
