import numpy as np

A = [[0,1,0,0,0,0,0,0]
    ,[1,0,1,0,0,1,0,0]
    ,[0,1,0,1,0,1,1,0]
    ,[0,0,1,0,1,0,0,0]
    ,[0,0,0,1,0,1,0,0]
    ,[0,1,1,0,1,0,1,0]
    ,[0,0,1,0,0,1,0,1]
    ,[0,0,0,0,0,0,1,0]]

A = np.array(A)

D = np.sum(A,axis=1)
L = np.diag(D) - A  # Non-Normalized Laplacian

print(L)

eigen_values, eigen_vectors = np.linalg.eigh(L)

print(eigen_values)

print(eigen_vectors)

gft = np.inner(eigen_vectors, A)
