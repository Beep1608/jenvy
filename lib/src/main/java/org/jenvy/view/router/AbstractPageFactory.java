package org.jenvy.view.router;

public abstract  class AbstractPageFactory implements PageFactory{


    @Override
    public IPage page(Class<? extends IPage> pageClass, IPageProvider provider) throws Exception {
        System.out.println("AbstractPageFctory -> " + pageClass.getName() );
        IPage IPage =  (IPage)  pageClass.getDeclaredConstructor().newInstance();
        System.out.println("Nombre Page: "+ IPage.name());
      IPage.setProvider(provider);

      return IPage;
    }

    @Override
    public IPage reset(IPage IPage) {
        IPage.reset();
        return IPage;
    }


}
