package devops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import devops.model.ProjectApplication;
import devops.dao.ProjectApplicationDao;
import de.terrestris.shogun2.service.ApplicationService;

/**
 * This is a demo service that demonstrates how a SHOGun2 service can be
 * extended.
 *
 * @author Nils Bühner
 *
 * @param <E>
 * @param <D>
 */
@Service("projectApplicationService")
public class ProjectApplicationService<E extends ProjectApplication, D extends ProjectApplicationDao<E>> extends
		ApplicationService<E, D> {

	/**
	 * We have to use {@link Qualifier} to define the correct dao here.
	 * Otherwise, spring can not decide which dao has to be autowired here
	 * as there are multiple candidates.
	 */
	@Override
	@Autowired
	@Qualifier("projectApplicationDao")
	public void setDao(D dao) {
		super.setDao(dao);
	}
}