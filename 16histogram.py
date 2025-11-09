import matplotlib.pyplot as plt
import numpy as np
data = np.array([
    [2.0, 3.0],
    [3.5, 5.0],
    [1.0, 2.0],
    [4.0, 4.5]
])
attr1 = data[:, 0]
attr2 = data[:, 1]
labels = ['Instance 1', 'Instance 2', 'Instance 3', 'Instance 4']
plt.figure(figsize=(10, 6))
plt.hist(attr1, bins=5, alpha=0.7, label='Attribute 1')
plt.hist(attr2, bins=5, alpha=0.7, label='Attribute 2')
plt.title('Histogram of Attributes')
plt.xlabel('Value')
plt.ylabel('Frequency')
plt.legend()
plt.show()
# Box Plot
plt.figure(figsize=(8, 6))
plt.boxplot([attr1, attr2], labels=['Attribute 1', 'Attribute 2'])
plt.title('Box Plot of Attributes')
plt.ylabel('Value')
plt.show()
# Bar Chart
plt.figure(figsize=(10, 6))
x = np.arange(len(labels))
width = 0.35
plt.bar(x - width/2, attr1, width, label='Attribute 1')
plt.bar(x + width/2, attr2, width, label='Attribute 2')
plt.xticks(x, labels)
plt.title('Bar Chart of Attributes')
plt.ylabel('Value')
plt.legend()
plt.show()
# Pie Chart (using Attribute 1 values)
plt.figure(figsize=(8, 8))
plt.pie(attr1, labels=labels, autopct='%1.1f%%', startangle=140)
plt.title('Pie Chart of Attribute 1')
plt.show()
