package com.builtbroken.grappling.content;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.Vec3;

/**
 * Object used to store the location of the hook part of the grappling gun
 */
public class Hook
{
    /** Hook location */
    public double x, y, z;
    /** Current rope distance */
    public double distance = -1;
    /** Side of the block attached to */
    public int side;
    /** Direction and speed of movement */
    public int movement;

    public int playerEntityID;

    public Vec3 toVec3()
    {
        return Vec3.createVectorHelper(x, y, z);
    }

    //TODO track rope distance so we can hold the player mid air

    @Override
    public String toString()
    {
        return "Hook[" + x + "x, " + y + "y, " + z + "z, " + side + "s, " + movement + "]@" + hashCode();
    }

    public void write(ByteBuf buffer)
    {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
        buffer.writeDouble(distance);
        buffer.writeInt(side);
        buffer.writeInt(playerEntityID);
    }

    public static Hook read(ByteBuf buffer)
    {
        Hook hook = new Hook();
        hook.x = buffer.readDouble();
        hook.y = buffer.readDouble();
        hook.z = buffer.readDouble();
        hook.distance = buffer.readDouble();
        hook.side = buffer.readInt();
        hook.playerEntityID = buffer.readInt();
        return hook;
    }
}