package top.wlz922.service;

import top.wlz922.bean.PropagationUser;

/**
 * @author Eddie
 */
public interface PropagationUserService {
	void addRequired(PropagationUser user);

	void addRequiredException(PropagationUser user);

	void addRequiredNew(PropagationUser user);

	void addRequiredNewException(PropagationUser user);

	void addSupports(PropagationUser user);

	void addSupportsException(PropagationUser user);

	void addNotSupported(PropagationUser user);

	void addNotSupportedException(PropagationUser user);

	void addMandatory(PropagationUser user);

	void addMandatoryException(PropagationUser user);

	void addNever(PropagationUser user);

	void addNeverException(PropagationUser user);

	void addNestead(PropagationUser user);

	void addNesteadException(PropagationUser user);
}
