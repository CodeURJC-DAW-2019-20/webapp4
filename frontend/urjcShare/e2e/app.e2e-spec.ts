import { UrjcSharePage } from './app.po';

describe('urjc-share App', function() {
  let page: UrjcSharePage;

  beforeEach(() => {
    page = new UrjcSharePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
