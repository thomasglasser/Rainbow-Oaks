package dev.thomasglasser.aliysium.rainbowoaks.platform;

import dev.thomasglasser.aliysium.rainbowoaks.platform.services.EntityHelper;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ForgeEntityHelper implements EntityHelper
{
	private final Map<String, DeferredRegister<EntityDataSerializer<?>>> DATA_SERIALIZERS = new HashMap<>();

	@Override
	public void registerDataSerializers(String modId, Map<String, EntityDataSerializer<?>> serializers)
	{
		DeferredRegister<EntityDataSerializer<?>> register = DATA_SERIALIZERS.computeIfAbsent(modId, id ->
		{
			DeferredRegister<EntityDataSerializer<?>> reg = DeferredRegister.create(ForgeRegistries.ENTITY_DATA_SERIALIZERS.get(), id);
			reg.register(FMLJavaModLoadingContext.get().getModEventBus());
			return reg;
		});
		serializers.forEach((name, serializer) -> register.register(name, () -> serializer));
	}
}
