package dev.thomasglasser.aliysium.rainbowoaks.platform;

import dev.thomasglasser.aliysium.rainbowoaks.platform.services.ParticleHelper;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class ForgeParticleHelper implements ParticleHelper
{
    @Override
    public SimpleParticleType simple(String name, PendingParticleFactory<SimpleParticleType> factory, boolean alwaysRender) {
        return new SimpleParticleType(alwaysRender);
    }

    @Override
    public <T extends ParticleOptions> void fabricRegister(ParticleType<T> type, PendingParticleFactory<T> factory) {}
}
