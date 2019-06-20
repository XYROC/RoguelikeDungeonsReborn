package greymerk.roguelike;

/*
 * Roguelike Dungeons Reborn
 * ORIGINAL MOD by Greymerk -> https://github.com/Greymerk/minecraft-roguelike
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(RoguelikeDungeonsReborn.MODID)

public class RoguelikeDungeonsReborn {

	public static final String MODID = "roguelikereborn";

	public static final String VERSION = "1.0.0";
	public static final String DATE = "Jun 20 2019";

	public static final Logger LOGGER = LogManager.getLogger("RoguelikeDungeonsReborn");

	public static DungeonGenerator worldGen = new DungeonGenerator();

	public RoguelikeDungeonsReborn() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EntityJoinWorld());
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	private void clientSetup(final FMLClientSetupEvent event) {
	}

	public static ResourceLocation locate(String path) {
		return new ResourceLocation(MODID, path);
	}

	/*
	 * TODO Register world generator
	 * 
	 * @EventHandler public void preInit(FMLPreInitializationEvent event) {
	 * GameRegistry.registerWorldGenerator(worldGen, 0); }
	 * 
	 */
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Feature<?>> event) {
            LOGGER.info("Features!!");
           // ForgeRegistries.FEATURES.register(value);
           // event.getRegistry().register(new );
        }
    }

}
