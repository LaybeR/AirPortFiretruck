package Controller.Commands;

import User.IUser;

public interface ICommand {
    public void execute(IUser user);
}
