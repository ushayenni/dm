
import numpy as np

def calculate_chi_square(observed, expected):
    observed = np.array(observed)
    expected = np.array(expected)
    chi_square = np.sum((observed - expected) ** 2 / expected)
    return chi_square

# Observed and expected frequencies
observed_values = [10, 15, 20, 25]
expected_values = [12, 15, 18, 25]

# Calculate chi-square value
chi_square_value = calculate_chi_square(observed_values, expected_values)

# Display result
print(f"The chi-square value is: {chi_square_value}")
