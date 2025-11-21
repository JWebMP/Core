package com.jwebmp.core.utilities;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * CRTP helper interface to standardize fluent self-typing across the codebase.
 * <p>
 * Usage:
 * <pre>
 *   public class Paragraph<J extends Paragraph<J>>
 *       extends ComponentHierarchyBase implements Self<J> {
 *     public @org.jspecify.annotations.NonNull J setText(String text) {
 *       this.text = text;
 *       return self();
 *     }
 *   }
 * </pre>
 *
 * - Prefer class signatures of the form {@code class X<J extends X<J>> implements Self<J>}.
 * - Use {@link #self()} to return the correctly typed instance from setters and chaining methods.
 * - {@link #with(Consumer)} and {@link #apply(Function)} are optional helpers for fluent configuration.
 */
public interface Self<J> {

    /**
     * @return this cast to the CRTP self type.
     */
    @SuppressWarnings("unchecked")
    default J self() {
        return (J) this;
    }

    /**
     * Apply a mutation or side-effect to the current instance and return it for chaining.
     * Example: component.with(c -> c.setId("x")).with(c -> c.add(child));
     */
    default J with(Consumer<J> action) {
        Objects.requireNonNull(action, "action");
        action.accept(self());
        return self();
    }

    /**
     * Map the current instance to some value without breaking the fluent style.
     * Example: String id = component.apply(Component::getId);
     */
    default <R> R apply(Function<J, R> mapper) {
        Objects.requireNonNull(mapper, "mapper");
        return mapper.apply(self());
    }
}
