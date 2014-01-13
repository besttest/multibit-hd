package org.multibit.hd.ui.views;

import com.google.common.base.Optional;
import org.multibit.hd.core.services.CoreServices;
import org.multibit.hd.ui.models.Model;

import javax.swing.*;

/**
 * <p>Abstract base class to provide the following to View implementors:</p>
 * <ul>
 * <li>Standard implementations of common methods</li>
 * </ul>
 *
 * @since 0.0.1
 *  
 */
public abstract class AbstractView<M extends Model> implements View<M> {

  private Optional<M> model = Optional.absent();

  protected JPanel panel;

  /**
   * @param model The model backing this view
   */
  public AbstractView(M model) {
    this.model = Optional.fromNullable(model);

    // Ensure that any event handlers are automatically registered
    CoreServices.uiEventBus.register(this);
  }

  @Override
  public Optional<M> getModel() {
    return model;
  }

  @Override
  public void setModel(M model) {
    this.model = Optional.fromNullable(model);
  }

  @Override
  public abstract void updateModel();

  @Override
  public abstract JPanel newPanel();

  @Override
  public JPanel currentPanel() {
    return panel;
  }
}