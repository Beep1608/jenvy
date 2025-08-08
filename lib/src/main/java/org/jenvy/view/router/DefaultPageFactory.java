package org.jenvy.view.router;

public final class DefaultPageFactory{

    private static IPageProvider provider;

    private final static AbstractPageFactory factory = new AbstractPageFactory() {
        @Override
        public IPage page(Class<? extends IPage> pageClass , IPageProvider provider) throws Exception {
            return super.page(pageClass, provider);
        }

        @Override
        public IPage reset(IPage IPage) {
            return super.reset(IPage);
        }
    };
    public DefaultPageFactory(IPageProvider provider){
        DefaultPageFactory.provider = provider;
    }

    public static IPage create(Class<? extends IPage> pageClass){
        try{
            System.out.println("DefaultPageFactory: Creando -> "+pageClass.getName());
            return factory.page(pageClass,provider);
        }catch (Exception e){
            throw new RuntimeException("No se pudo crear la Page :"+pageClass.getName());
        }

    }

    public static IPage reset(IPage IPage){
        return factory.reset(IPage);
    }

}