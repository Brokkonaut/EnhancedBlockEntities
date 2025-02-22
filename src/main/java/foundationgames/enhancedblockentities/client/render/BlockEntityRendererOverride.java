package foundationgames.enhancedblockentities.client.render;

import foundationgames.enhancedblockentities.event.EBEEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public abstract class BlockEntityRendererOverride {
    public static final BlockEntityRendererOverride NO_OP = new BlockEntityRendererOverride() {
        @Override
        public void render(BlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {}
    };

    public BlockEntityRendererOverride() {
        EBEEvents.RELOAD_MODELS.register((loader, manager, profiler) -> this.onModelsReload());
    }

    public abstract void render(BlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay);

    public void onModelsReload() {}

}
