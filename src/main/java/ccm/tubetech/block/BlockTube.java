package ccm.tubetech.block;

import ccm.tubetech.tile.TileTube;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTube extends BlockContainer
{
    public BlockTube(int par1)
    {
        super(par1, Material.glass);
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hx, float hy, float hz)
    {
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te instanceof TileTube)
        {
            return ((TileTube) te).click(player);
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileTube(world);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }
}
