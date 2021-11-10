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

package com.github.retrooper.packetevents.protocol.chat.component;

import com.github.retrooper.packetevents.protocol.chat.Color;
import org.json.simple.JSONObject;

public class TextComponent extends BaseComponent {
    private String text;

    public TextComponent() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.text = (String) jsonObject.getOrDefault("text", "");
        super.parseJSON(jsonObject);
    }

    @Override
    public JSONObject buildJSON() {
        JSONObject jsonObject = super.buildJSON();
        jsonObject.put("text", text);
        return jsonObject;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T extends TextComponent> extends BaseComponent.Builder<T> {
        private final TextComponent component = new TextComponent();

        public Builder text(String text) {
            this.component.setText(text);
            return this;
        }

        @Override
        public Builder color(Color color) {
            this.component.setColor(color);
            return this;
        }

        @Override
        public Builder bold(boolean bold) {
            this.component.setBold(bold);
            return this;
        }

        @Override
        public Builder italic(boolean italic) {
            this.component.setItalic(italic);
            return this;
        }

        @Override
        public Builder underlined(boolean underlined) {
            this.component.setUnderlined(underlined);
            return this;
        }

        @Override
        public Builder strikeThrough(boolean strikeThrough) {
            this.component.setStrikeThrough(strikeThrough);
            return this;
        }

        @Override
        public Builder obfuscated(boolean obfuscated) {
            this.component.setObfuscated(obfuscated);
            return this;
        }

        @Override
        public Builder insertion(String insertion) {
            this.component.setInsertion(insertion);
            return this;
        }

        @Override
        public Builder openURLClickEvent(String value) {
            this.component.setOpenURLClickEvent(new ClickEvent(ClickEvent.ClickType.OPEN_URL, value));
            return this;
        }

        @Override
        public Builder openFileClickEvent(String value) {
            this.component.setOpenFileClickEvent(new ClickEvent(ClickEvent.ClickType.OPEN_FILE, value));
            return this;
        }

        @Override
        public Builder runCommandClickEvent(String value) {
            this.component.setRunCommandClickEvent(new ClickEvent(ClickEvent.ClickType.RUN_COMMAND, value));
            return this;
        }

        @Override
        public Builder suggestCommandClickEvent(String value) {
            this.component.setSuggestCommandClickEvent(new ClickEvent(ClickEvent.ClickType.SUGGEST_COMMAND, value));
            return this;
        }

        @Override
        public Builder changePageClickEvent(String value) {
            this.component.setChangePageClickEvent(new ClickEvent(ClickEvent.ClickType.CHANGE_PAGE, value));
            return this;
        }

        @Override
        public Builder copyToClipboardClickEvent(String value) {
            this.component.setCopyToClipboardClickEvent(new ClickEvent(ClickEvent.ClickType.COPY_TO_CLIPBOARD, value));
            return this;
        }

        @Override
        public BaseComponent.Builder showTextHoverEvent(String value) {
            this.component.setShowTextHoverEvent(new HoverEvent(HoverEvent.HoverType.SHOW_TEXT, value));
            return this;
        }

        @Override
        public BaseComponent.Builder showItemHoverEvent(String value) {
            this.component.setShowItemHoverEvent(new HoverEvent(HoverEvent.HoverType.SHOW_ITEM, value));
            return this;
        }

        @Override
        public BaseComponent.Builder showEntityHoverEvent(String value) {
            this.component.setShowEntityHoverEvent(new HoverEvent(HoverEvent.HoverType.SHOW_ENTITY, value));
            return this;
        }

        @Override
        public BaseComponent.Builder showAchievementHoverEvent(String value) {
            this.component.setShowAchievementHoverEvent(new HoverEvent(HoverEvent.HoverType.SHOW_ACHIEVEMENT, value));
            return this;
        }

        @Override
        public T build() {
            return (T) component;
        }
    }
}
