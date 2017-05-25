package gc.autoanuncio;

import java.io.File;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class AutoAnuncio extends JavaPlugin {
	
	public List<String> mensagens = getConfig().getStringList("Mensagens");
	public int delay = getConfig().getInt("Configuracao.delay") * 60;
	
	
	@SuppressWarnings("unused")
	@Override
	public void onEnable() {
		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
		BukkitTask Anunciar = new Anunciar(mensagens).runTaskTimer(this, 20 * delay, 20 * delay);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("gcaa")){
			if(p.hasPermission("gcaanuncio.reload")){
				reloadConfig();
				p.sendMessage("§4Reload na config com sucesso.");
				return true;
			}
		}
		return false;
	}
	
}
