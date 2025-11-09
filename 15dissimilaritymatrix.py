import numpy as np
from scipy.spatial.distance import pdist, squareform
data = np.array([
    [2.0, 3.0],
    [3.5, 5.0],
    [1.0, 2.0],
    [4.0, 4.5]
])
dissimilarity_matrix = squareform(pdist(data, metric='euclidean'))
print("Dissimilarity Matrix (Euclidean Distance):")
print(dissimilarity_matrix)
