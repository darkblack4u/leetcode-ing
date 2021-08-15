> ## 1. pandas

**pandas.read_csv** [api](https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.read_csv.html) [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/io/parsers/readers.py#L491-L586) return **pandas.DataFrame**

**pandas.DataFrame** [api](https://pandas.pydata.org/docs/reference/api/pandas.DataFrame.html) [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/core/frame.py#L456-L10748)
- `drop`删除行或者列 DataFrame.drop(labels=None, axis=0, index=None, columns=None, level=None, inplace=False, errors='raise') [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/core/frame.py#L4769-L4909)
    - `labels`: single label or list-like
    - `axis`: {0 or ‘index’, 1 or ‘columns’}, default 0
    - `index`: single label or list-like
    - `columns`: single label or list-like
- `to_csv`写CSV文件

> ## 2. sklearn

> ### 1. sklearn.linear_model
**sklearn.linear_model** 线性模型 [api](https://scikit-learn.org/stable/modules/linear_model.html) `coef_`系数/`intercept_`Bias

- `LinearRegression` [api](https://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html#sklearn.linear_model.LinearRegression) [source](https://github.com/scikit-learn/scikit-learn/blob/2beed5584/sklearn/linear_model/_base.py#L391)
    - todo
- `Ridge` 岭回归，L2正则 [api](https://scikit-learn.org/stable/modules/generated/sklearn.linear_model.Ridge.html#sklearn.linear_model.Ridge) [source](https://github.com/scikit-learn/scikit-learn/blob/2beed5584/sklearn/linear_model/_ridge.py#L603) `sklearn.linear_model.Ridge(alpha=1.0, *, fit_intercept=True, normalize=False, copy_X=True, max_iter=None, tol=0.001, solver='auto', random_state=None)`
    - `alpha`: 正则化强度; 必须是正浮点数。
    - `solver`: `{‘auto’，’svd’，’cholesky’，’lsqr’，’sparse_cg’，’sag’}`, 用于计算的求解方法：
        - `auto`: 根据数据类型自动选择求解器。
        - `svd`: 使用X的奇异值分解来计算Ridge系数。对于奇异矩阵比’cholesky’更稳定。
        - `cholesky`: 使用标准的scipy.linalg.solve函数来获得闭合形式的解。
        - `sparse_cg`: 使用在scipy.sparse.linalg.cg中找到的共轭梯度求解器。作为迭代算法，这个求解器比大规模数据（设置tol和max_iter的可能性）的“cholesky”更合适。
        - `lsqr`: 使用专用的正则化最小二乘常数scipy.sparse.linalg.lsqr。它是最快的，但可能不是在旧的scipy版本可用。它还使用迭代过程。
        - `sag`: 使用随机平均梯度下降。它也使用迭代过程，并且当n_samples和n_feature都很大时，通常比其他求解器更快。注意，“sag”快速收敛仅在具有近似相同尺度的特征上被保证。
    - `tol`: float, 解的精度。
    - `random_state`: int seed，RandomState实例或None（默认）伪随机数生成器的种子，当混洗数据时使用。 仅用于’sag’求解器。新版本0.17：random_state支持随机平均渐变。
- `RidgeClassifier` 岭分类，L2正则，同`Ridge`，不同的是输出{-1, 1}。并且可以多分类
    - `class_weight`: dict or ‘balanced’, default=None
