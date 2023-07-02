# Java Optional Best Practices

This repository explores the best practices for using the `Optional` class in Java to handle potentially absent values. By following these guidelines, you can effectively leverage `Optional` and improve the clarity and safety of your code.

## Rules for Using Optional

1. **Rule #1: Never, ever, use `null` for an optional variable or return value:** Instead of using `null`, embrace the use of `Optional` to indicate the absence of a value. This helps prevent `NullPointerExceptions` and promotes safer code.

2. **Rule #2: Never use `Optional.get()` unless you can prove that the `Optional` is present:** Avoid using `get()`, which can throw a `NoSuchElementException`. Instead, use alternative methods like `orElse`, `orElseGet`, or `orElseThrow` to handle the absence of a value safely.

3. **Rule #3: Prefer alternatives to `Optional.isPresent()` and `Optional.get()`:** Instead of explicitly checking for presence with `isPresent()` and accessing the value with `get()`, use methods like `orElse`, `orElseGet`, `orElseThrow`, or `ifPresent` to handle the absence of a value more effectively.

4. **Rule #4: It’s generally a bad idea to create an `Optional` for method chaining:** Avoid creating an `Optional` solely for the purpose of method chaining. This can introduce unnecessary complexity and reduce code readability. Use `Optional` where it makes sense in the broader context of your code.

5. **Rule #5: Be cautious with nested `Optional` chains:** When nesting `Optional` types or having intermediate results of `Optional<Optional<T>>`, the code becomes complex and harder to understand. Consider refactoring the logic to simplify it.

6. **Rule #6: Avoid using `Optional` in fields, method parameters, and collections:** While `Optional` is useful for return types, it is generally not recommended for fields, method parameters, or collections. Using `Optional` in these scenarios can complicate code and reduce performance. Stick to conventional null checks instead.

7. **Rule #7: Avoid using identity-sensitive operations on Optionals:** Be careful when using identity-sensitive operations like `==` or `!=` to compare `Optional` instances. `Optional` is value-based, not identity-based, so these operations might not yield the expected results.

## Example Usage

Consider the following example that demonstrates the addition of `Optional<BigDecimal>` values:

```java
Optional<BigDecimal> firstNumber = Optional.of(new BigDecimal(10));
Optional<BigDecimal> secondNumber = Optional.of(new BigDecimal(12));

// After addition:
Optional<BigDecimal> result = firstNumber.flatMap(a ->
                                 secondNumber.map(b -> a.add(b))
                             );

// If both numbers are present, add them
// If one of them is empty, treat it as zero and add it to the other
// If both are empty, return empty

