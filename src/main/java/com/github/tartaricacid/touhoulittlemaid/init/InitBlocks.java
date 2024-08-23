package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.block.BlockAltar;
import com.github.tartaricacid.touhoulittlemaid.block.BlockBookshelf;
import com.github.tartaricacid.touhoulittlemaid.block.BlockComputer;
import com.github.tartaricacid.touhoulittlemaid.block.BlockGarageKit;
import com.github.tartaricacid.touhoulittlemaid.block.BlockGomoku;
import com.github.tartaricacid.touhoulittlemaid.block.BlockKeyboard;
import com.github.tartaricacid.touhoulittlemaid.block.BlockMaidBeacon;
import com.github.tartaricacid.touhoulittlemaid.block.BlockMaidBed;
import com.github.tartaricacid.touhoulittlemaid.block.BlockModelSwitcher;
import com.github.tartaricacid.touhoulittlemaid.block.BlockPicnicMat;
import com.github.tartaricacid.touhoulittlemaid.block.BlockShrine;
import com.github.tartaricacid.touhoulittlemaid.block.BlockStatue;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityAltar;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityBookshelf;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityComputer;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityGarageKit;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityGomoku;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityKeyboard;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityMaidBeacon;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityModelSwitcher;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityPicnicMat;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityShrine;
import com.github.tartaricacid.touhoulittlemaid.tileentity.TileEntityStatue;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class InitBlocks {
    public static final LazyRegistrar<Block> BLOCKS = LazyRegistrar.create(BuiltInRegistries.BLOCK, TouhouLittleMaid.MOD_ID);
    public static final LazyRegistrar<BlockEntityType<?>> TILE_ENTITIES = LazyRegistrar.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TouhouLittleMaid.MOD_ID);

    public static RegistryObject<Block> MAID_BED = BLOCKS.register("maid_bed", BlockMaidBed::new);
    public static RegistryObject<Block> ALTAR = BLOCKS.register("altar", BlockAltar::new);
    public static RegistryObject<Block> STATUE = BLOCKS.register("statue", BlockStatue::new);
    public static RegistryObject<Block> GARAGE_KIT = BLOCKS.register("garage_kit", BlockGarageKit::new);
    public static RegistryObject<Block> MAID_BEACON = BLOCKS.register("maid_beacon", BlockMaidBeacon::new);
    public static RegistryObject<Block> MODEL_SWITCHER = BLOCKS.register("model_switcher", BlockModelSwitcher::new);
    public static RegistryObject<Block> PICNIC_MAT = BLOCKS.register("picnic_mat", BlockPicnicMat::new);
    public static RegistryObject<Block> GOMOKU = BLOCKS.register("gomoku", BlockGomoku::new);
    public static RegistryObject<Block> KEYBOARD = BLOCKS.register("keyboard", BlockKeyboard::new);
    public static RegistryObject<Block> BOOKSHELF = BLOCKS.register("bookshelf", BlockBookshelf::new);
    public static RegistryObject<Block> COMPUTER = BLOCKS.register("computer", BlockComputer::new);
    public static RegistryObject<Block> SHRINE = BLOCKS.register("shrine", BlockShrine::new);

    public static RegistryObject<BlockEntityType<TileEntityAltar>> ALTAR_TE = TILE_ENTITIES.register("altar", () -> TileEntityAltar.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityStatue>> STATUE_TE = TILE_ENTITIES.register("statue", () -> TileEntityStatue.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityGarageKit>> GARAGE_KIT_TE = TILE_ENTITIES.register("garage_kit", () -> TileEntityGarageKit.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityMaidBeacon>> MAID_BEACON_TE = TILE_ENTITIES.register("maid_beacon", () -> TileEntityMaidBeacon.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityModelSwitcher>> MODEL_SWITCHER_TE = TILE_ENTITIES.register("model_switcher", () -> TileEntityModelSwitcher.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityGomoku>> GOMOKU_TE = TILE_ENTITIES.register("gomoku", () -> TileEntityGomoku.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityKeyboard>> KEYBOARD_TE = TILE_ENTITIES.register("keyboard", () -> TileEntityKeyboard.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityBookshelf>> BOOKSHELF_TE = TILE_ENTITIES.register("bookshelf", () -> TileEntityBookshelf.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityComputer>> COMPUTER_TE = TILE_ENTITIES.register("computer", () -> TileEntityComputer.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityShrine>> SHRINE_TE = TILE_ENTITIES.register("shrine", () -> TileEntityShrine.TYPE);
    public static RegistryObject<BlockEntityType<TileEntityPicnicMat>> PICNIC_MAT_TE = TILE_ENTITIES.register("picnic_mat", () -> TileEntityPicnicMat.TYPE);
}
