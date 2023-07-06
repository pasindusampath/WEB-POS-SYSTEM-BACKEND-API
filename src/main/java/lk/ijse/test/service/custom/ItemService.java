package lk.ijse.test.service.custom;

import lk.ijse.test.db.FactoryConfiguration;
import lk.ijse.test.dto.custom.ItemDTO;
import lk.ijse.test.repo.custom.ItemRepo;
import lk.ijse.test.repo.util.RepoFactory;
import lk.ijse.test.service.CrudService;

public interface ItemService extends CrudService<ItemDTO,Integer> {
    ItemRepo repo=RepoFactory.getInstance().getRepo(RepoFactory.Type.ITEM);
}
