/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2021 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.retrooper.packetevents.protocol.data.world.chunk.impl.v1_15;

import com.github.retrooper.packetevents.protocol.data.stream.NetStreamInput;
import com.github.retrooper.packetevents.protocol.data.stream.NetStreamOutput;

public class BlockState {
    private final int id;

    public BlockState(int id) {
        this.id = id;
    }

    public static BlockState read(NetStreamInput in) {
        return new BlockState(in.readVarInt());
    }

    public static void write(NetStreamOutput out, BlockState blockState) {
        out.writeVarInt(blockState.getID());
    }

    public int getID() {
        return id;
    }
}
