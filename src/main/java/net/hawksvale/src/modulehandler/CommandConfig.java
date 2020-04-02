package net.hawksvale.src.modulehandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

public class CommandConfig {
	
	private Boolean doTabCompletion;
	private List<CommandName> names;
	
	public CommandConfig(@Nonnull Boolean doTabCompletion, @Nonnull String... names) {
		this.doTabCompletion = doTabCompletion;
		this.names = new ArrayList<>();
		Arrays.asList(names).forEach(name -> this.names.add(new CommandName(name, doTabCompletion)));
	}
	
	public CommandConfig(@Nonnull String... names) {
		this.doTabCompletion = false;
		this.names = new ArrayList<>();
		Arrays.asList(names).forEach(name -> this.names.add(new CommandName(name, doTabCompletion)));
	}
	
	public CommandConfig(@Nonnull CommandName... names) {
		this.doTabCompletion = true;
		this.names = new ArrayList<>();
		this.names.addAll(Arrays.asList(names));
	}
	
	public CommandConfig() {
		this.doTabCompletion = false;
		this.names = null;
	}
	
	public List<CommandName> getNames() {
		return names;
	}
	
	public boolean doesDoTabCompletion() {
		return doTabCompletion;
	}

}
