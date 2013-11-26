package ccm.tubetech;

import static ccm.tubetech.util.Data.*;
import cpw.mods.fml.common.Mod;

@Mod(modid = MODID, name = MODID)
public class TubeTech
{
    @Mod.Instance(MODID)
    private static TubeTech instance;

    public static TubeTech getInstance()
    {
        return instance;
    }
}
