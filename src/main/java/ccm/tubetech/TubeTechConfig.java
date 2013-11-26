package ccm.tubetech;

import static ccm.tubetech.util.Data.*;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class TubeTechConfig
{
    public final int BLOCKID_TUBE;

    final Configuration configuration;

    TubeTechConfig(FMLPreInitializationEvent event)
    {
        configuration = new Configuration(event.getSuggestedConfigurationFile());

        BLOCKID_TUBE = configuration.getBlock(MODID + "_Tube", 486).getInt();

        configuration.save();
    }
}
