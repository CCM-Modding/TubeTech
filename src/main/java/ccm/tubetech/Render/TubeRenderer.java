package ccm.tubetech.Render;

import ccm.tubetech.tile.TileTube;
import ccm.tubetech.util.EnumSymbol;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class TubeRenderer extends TileEntitySpecialRenderer
{
    public static final IModelCustom BASE_OBJ = AdvancedModelLoader.loadModel("/assets/TubeTech/models/base.obj");
    public static final IModelCustom TUBE_OBJ = AdvancedModelLoader.loadModel("/assets/TubeTech/models/tube.obj");
    public static final IModelCustom SYMBOL_OJB = AdvancedModelLoader.loadModel("/assets/TubeTech/models/symbol.obj");

    public static final ResourceLocation BASE_T = new ResourceLocation("tubetech:models/nixie_base.png");
    public static final ResourceLocation TUBE_T = new ResourceLocation("tubetech:models/glass.png");

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float p)
    {
        if (entity instanceof TileTube)
        {
            GL11.glPushMatrix();
            GL11.glTranslated(x+0.5, y, z+0.5);
            GL11.glScaled(0.4,0.4,0.4);

            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);

            //GL11.glDisable(GL11.GL_DEPTH_TEST);
            bind(((TileTube) entity).getTexture());
            SYMBOL_OJB.renderAll();

            GL11.glRotated(180, 0,1,0);
            bind(((TileTube) entity).getTexture());
            SYMBOL_OJB.renderAll();
            GL11.glRotated(-180, 0,1,0);

            /**
             * TODO: @CCM crew: Fix model or texture!
             */

            bind(BASE_T);
            BASE_OBJ.renderAll();
            //BASE_OBJ.renderAllExcept("Front", "Back", "Plane004", "Plane004", "Plane005", "Plane006", "Plane007", "Plane008", "Plane009", "Plane010", "Plane011", "Plane012", "Plane013", "Plane014");

            bind(TUBE_T);
            TUBE_OBJ.renderAll();

            //GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);

            GL11.glPopMatrix();
        }
    }

    private void bind(ResourceLocation texture)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
    }
}
