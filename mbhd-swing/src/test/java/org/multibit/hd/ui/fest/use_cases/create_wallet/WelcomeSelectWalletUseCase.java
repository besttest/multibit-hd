package org.multibit.hd.ui.fest.use_cases.create_wallet;

import org.fest.swing.fixture.FrameFixture;
import org.multibit.hd.ui.fest.use_cases.AbstractFestUseCase;
import org.multibit.hd.ui.languages.Languages;
import org.multibit.hd.ui.languages.MessageKey;

import java.util.Map;

/**
 * <p>Use case to provide the following to FEST testing:</p>
 * <ul>
 * <li>Verify the welcome wizard "select wallet" panel view</li>
 * </ul>
 *
 * @since 0.0.1
 *  
 */
public class WelcomeSelectWalletUseCase extends AbstractFestUseCase {

  public WelcomeSelectWalletUseCase(FrameFixture window) {
    super(window);
  }

  @Override
  public void execute(Map<String, Object> parameters) {

    window
      .label(MessageKey.SELECT_WALLET_TITLE.getKey())
      .requireText(Languages.safeText(MessageKey.SELECT_WALLET_TITLE));

    window
      .radioButton(MessageKey.CREATE_WALLET.getKey())
      .requireSelected()
      .requireEnabled()
      .requireVisible();

    window
      .radioButton(MessageKey.RESTORE_WALLET.getKey())
      .requireNotSelected()
      .requireEnabled()
      .requireVisible();

    window
      .radioButton(MessageKey.USE_HARDWARE_WALLET.getKey())
      .requireNotSelected()
      .requireDisabled()
      .requireVisible();

    // OK to proceed
    window
      .button(MessageKey.NEXT.getKey())
      .click();

  }

}
