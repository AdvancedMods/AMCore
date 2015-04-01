package com.advancedmods.amcore.core.mod.updater;

import com.advancedmods.amcore.common.handler.ConfigurationHandler;
import com.advancedmods.amcore.core.AMCoreProps;
import com.google.common.base.Strings;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

import static net.minecraft.util.EnumChatFormatting.*;

public class UpdateManager {

	private static transient int pollOffset = 0;
	private static final ChatStyle description = new ChatStyle();
	private static final ChatStyle version = new ChatStyle();
	static {

		description.setColor(GRAY);
		version.setColor(AQUA);
	}

	public static void registerUpdater(UpdateManager manager) {

		FMLCommonHandler.instance().bus().register(manager);
	}

	private boolean _notificationDisplayed;
	private final IUpdatableMod _mod;
	private final UpdateCheckThread _updateThread;
	private final String _downloadUrl;
	private int lastPoll = 400;

	public UpdateManager(IUpdatableMod mod) {

		this(mod, null);
	}

	public UpdateManager(IUpdatableMod mod, String releaseUrl) {

		this(mod, releaseUrl, null);
	}

	public UpdateManager(IUpdatableMod mod, String releaseUrl, String downloadUrl) {

		_mod = mod;
		_updateThread = new UpdateCheckThread(mod, releaseUrl);
		_updateThread.start();
		_downloadUrl = downloadUrl;
		lastPoll += (pollOffset += 140);
	}

	@SubscribeEvent
	public void tickStart(PlayerTickEvent evt) {

		if (evt.phase != Phase.START) {
			return;
		}
		if (lastPoll > 0) {
			--lastPoll;
			return;
		}
		lastPoll = 400;

		if (!_notificationDisplayed && _updateThread.checkComplete()) {
			_notificationDisplayed = true;
			FMLCommonHandler.instance().bus().unregister(this);
			if (_updateThread.newVersionAvailable()) {
				if (!ConfigurationHandler.enableUpdateNotice && !_updateThread.isCriticalUpdate()) {
					return;
				}
				ModVersion newVersion = _updateThread.newVersion();

				EntityPlayer player = evt.player;
				player.addChatMessage(new ChatComponentText(GOLD + "[" + _mod.getModName() + "]").appendText(WHITE + " A new version is available:"));
				IChatComponent chat;
				String text = newVersion.modVersion().toString();
				if (Strings.isNullOrEmpty(_downloadUrl)) {
					chat = new ChatComponentText(text).setChatStyle(version);
				} else {
					chat = IChatComponent.Serializer.func_150699_a("[{\"text\":\"" + text + "\",\"color\":\"aqua\"}," + "{\"text\":\" " + WHITE + "[" + GREEN
							+ "Download" + WHITE + "]\"," + "\"color\":\"green\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":"
							+ "{\"text\":\"Click this to download the latest version\",\"color\":\"yellow\"}},"
							+ "\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + _downloadUrl + "\"}}]");
				}
				player.addChatMessage(chat);
				player.addChatMessage(new ChatComponentText(newVersion.description()).setChatStyle(description));
			}
		}
	}

}
