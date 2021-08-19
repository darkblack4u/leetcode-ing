> ## 1. pandas

- **pandas.read_csv** [api](https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.read_csv.html) [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/io/parsers/readers.py#L491-L586) return **pandas.DataFrame**

- **pandas.DataFrame** [api](https://pandas.pydata.org/docs/reference/api/pandas.DataFrame.html) [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/core/frame.py#L456-L10748)
    - `drop`删除行或者列 DataFrame.drop(labels=None, axis=0, index=None, columns=None, level=None, inplace=False, errors='raise') [source](https://github.com/pandas-dev/pandas/blob/v1.3.1/pandas/core/frame.py#L4769-L4909)
        - `labels`: single label or list-like
        - `axis`: {0 or ‘index’, 1 or ‘columns’}, default 0
        - `index`: single label or list-like
        - `columns`: single label or list-like
    - `to_csv`写CSV文件
    - `fillna`: 补全空值
- **get_dummies** 将分类变量转换为虚拟/指示符变量.one_hot_encoding
    - `get_dummies(data, prefix=None, prefix_sep='_', dummy_na=False, columns=None, sparse=False, drop_first=False, dtype=None)` [api](https://pandas.pydata.org/docs/reference/api/pandas.get_dummies.html) [source](https://github.com/pandas-dev/pandas/blob/v1.3.2/pandas/core/reshape/reshape.py#L774-L957)
- **concat** 链接两个df，eg：`pd.concat([df,dummies],axis='columns')`


> ## 2. sklearn

> ### 2.1. sklearn.linear_model 线性模型 [api](https://scikit-learn.org/stable/modules/linear_model.html) `coef_` (系数)/`intercept_` (Bias)

- `LinearRegression` [api](https://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html#sklearn.linear_model.LinearRegression) [source](https://github.com/scikit-learn/scikit-learn/blob/2beed5584/sklearn/linear_model/_base.py#L391) `LinearRegression(*, fit_intercept=True, normalize=False, copy_X=True, n_jobs=None, positive=False)`
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
- `RidgeCV` Ridge regression with built-in cross-validation. 
    - `alphas`: Array of alpha values to try. default=(0.1, 1.0, 10.0)
    - `cv`: int, cross-validation generator or an iterable, default=None
        - None, to use the efficient Leave-One-Out cross-validation, if y is binary or multiclass, `StratifiedKFold` is used
        - integer, to specify the number of folds. if y is binary or multiclass, `StratifiedKFold` is used
        - CV splitter [api](https://scikit-learn.org/stable/glossary.html#term-CV-splitter)
        - An iterable yielding (train, test) splits as arrays of indices.
- `RidgeClassifierCV` 
- `LogisticRegression`: 
    - `decision_function(X)`
    : Predict confidence scores for samples.
    - `densify()`: Convert coefficient matrix to dense array format.
    - `predict(X)`: Predict class labels for samples in X.
    - `predict_log_proba(X)`: Predict logarithm of probability estimates.
    - `predict_proba(X)`: Probability estimates.

Convert coefficient matrix to sparse format.

> ### 2.2 sklearn.model_selection 模型选择 [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.model_selection)

- `train_test_split`: 划分训练机和验证集 eg: `X_train, X_test, y_train, y_test = train_test_split(X,y,test_size=0.3) ` [api](http://scikit-learn.org/stable/modules/generated/sklearn.model_selection.train_test_split.html)
    - sklearn.model_selection.train_test_split(*arrays, test_size=None, train_size=None, random_state=None, shuffle=True, stratify=None)
- `KFold`: K-Folds cross-validator. `KFold(n_splits=5, *, shuffle=False, random_state=None)`
- `RepeatedKFold`: `RepeatedKFold(*, n_splits=5, n_repeats=10, random_state=None)`
- `StratifiedKFold`: 分层K-折叠交叉验证程序。`StratifiedKFold(n_splits=5, *, shuffle=False, random_state=None)` **能确保每一类的分布跟原数据集一致**
- `RepeatedStratifiedKFold`: Repeated Stratified K-Fold cross validator. `RepeatedStratifiedKFold(*, n_splits=5, n_repeats=10, random_state=None)`

> ### 2.3 sklearn.preprocessing 预处理

主要方法: `fit_transform`, `fit`, `transform`

- `OrdinalEncoder`: Encode categorical features as an integer array. [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.OrdinalEncoder.html#sklearn.preprocessing.OrdinalEncoder)
- `OneHotEncoder`: 使用K中的一个，也称为一个热编码或伪编码。[api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.OneHotEncoder.html#sklearn.preprocessing.OneHotEncoder)
- `normalize`: Scale input vectors individually to unit norm (vector length). [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.normalize.html#sklearn.preprocessing.normalize)
- `StandardScaler`: 线性变换z=(x-u)/s [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.StandardScaler.html#sklearn.preprocessing.StandardScaler)
- `MinMaxScaler`: 线性变换到[min, max]，默认[0, 1] [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.MinMaxScaler.html#sklearn.preprocessing.MinMaxScaler)
- `MaxAbsScaler`: 线性变换到[-a, a], 默认[-1, 1] [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.MaxAbsScaler.html#sklearn.preprocessing.MaxAbsScaler)
- `Binarizer`: 二值化 >threshold为1，否则为0 [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.Binarizer.html#sklearn.preprocessing.Binarizer)
- `KBinsDiscretizer`: 将连续数据分为若干间隔。 [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.KBinsDiscretizer.html#sklearn.preprocessing.KBinsDiscretizer)
- `PolynomialFeatures`: 生成多项式特征。[a, b], the degree-2 polynomial features are [1, a, b, a^2, ab, b^2]. [api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.PolynomialFeatures.html#sklearn.preprocessing.PolynomialFeatures)
- `FunctionTransformer`: 从任意可调用函数构造转换器。[api](https://scikit-learn.org/stable/modules/generated/sklearn.preprocessing.FunctionTransformer.html#sklearn.preprocessing.FunctionTransformer)


> ### 2.4 sklearn.datasets 数据集 [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.datasets)

- `load_digits()`: 	Load and return the digits dataset (classification) 数字分类. [api](https://scikit-learn.org/stable/modules/generated/sklearn.datasets.load_digits.html#sklearn.datasets.load_digits)


> ### 2.5 sklearn.metrics 指标 [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.metrics)

- Classification metrics 常用
    - `accuracy_score`
    - `auc`
    - `average_precision_score`
    - `balanced_accuracy_score`
    - `classification_report`
    - `cohen_kappa_score`
    - `confusion_matrix`
    - `multilabel_confusion_matrix`
    - `f1_score`
    - `fbeta_score`
    - `hamming_loss`
    - `log_loss`
    - `hinge_loss`
    - `zero_one_loss`
    - `precision_recall_curve`
    - `precision_recall_fscore_support`
    - `precision_score`
    - `recall_score`
    - `roc_auc_score`
    - `roc_curve`
    - `top_k_accuracy_score`
    - `zero_one_loss`
- Regression metrics
    - 

> ### 2.6 sklearn.tree: Decision Trees [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.tree)

- `tree.DecisionTreeClassifier`: A decision tree classifier. max_depth和max_leaf_nodes都能限制树的生长
- `tree.DecisionTreeRegressor`: A decision tree regressor.
- `tree.ExtraTreeClassifier`: An extremely randomized tree classifier.
- `tree.ExtraTreeRegressor`: An extremely randomized tree regressor.
- `tree.export_graphviz(decision_tree[, …])`: Export a decision tree in DOT format.
- `tree.export_text(decision_tree, *[, …])`: Build a text report showing the rules of a decision tree.
- `tree.plot_tree(decision_tree, *[, …])`: Plot a decision tree.


> ### 2.7 sklearn.svm [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.svm)

- `svm.LinearSVC([penalty, loss, dual, tol, C, …])`: Linear Support Vector Classification.
- `svm.LinearSVR(*[, epsilon, tol, C, loss, …])`: Linear Support Vector Regression.
- `svm.NuSVC(*[, nu, kernel, degree, gamma, …])`: Nu-Support Vector Classification.
- `svm.NuSVR(*[, nu, C, kernel, degree, gamma, …])`: Nu Support Vector Regression.
- `svm.OneClassSVM(*[, kernel, degree, gamma, …])`: Unsupervised Outlier Detection.
- `svm.SVC(*[, C, kernel, degree, gamma, …])`: C-Support Vector Classification.
- `svm.SVR(*[, kernel, degree, gamma, coef0, …])`: Epsilon-Support Vector Regression.
- `svm.l1_min_c(X, y, *[, loss, fit_intercept, …])`: Return the lowest bound for C such that for C in (l1_min_C, infinity) the model is guaranteed not to be empty.

> ### 2.8 sklearn.ensemble: Ensemble Methods [api](https://scikit-learn.org/stable/modules/classes.html#module-sklearn.ensemble)

- `ensemble.AdaBoostClassifier([…])`:  An AdaBoost classifier.
- `ensemble.AdaBoostRegressor([base_estimator, …])`: An AdaBoost regressor.
- `ensemble.BaggingClassifier([base_estimator, …])`: A Bagging classifier.
- `ensemble.BaggingRegressor([base_estimator, …])`: A Bagging regressor.
- `ensemble.ExtraTreesClassifier([…])`: An extra-trees classifier.
- `ensemble.ExtraTreesRegressor([n_estimators, …])`: An extra-trees regressor.
- `ensemble.GradientBoostingClassifier(*[, …])`: Gradient Boosting for classification.
- `ensemble.GradientBoostingRegressor(*[, …])`: Gradient Boosting for regression.
- `ensemble.IsolationForest(*[, n_estimators, …])`: Isolation Forest Algorithm.
- `ensemble.RandomForestClassifier([…])`: A random forest classifier.
- `ensemble.RandomForestRegressor([…])`: A random forest regressor.
- `ensemble.RandomTreesEmbedding([…])`: An ensemble of totally random trees.
- `ensemble.StackingClassifier(estimators[, …])`: Stack of estimators with a final classifier.
- `ensemble.StackingRegressor(estimators[, …])`: Stack of estimators with a final regressor.
- `ensemble.VotingClassifier(estimators, *[, …])`: Soft Voting/Majority Rule classifier for unfitted estimators.
- `ensemble.VotingRegressor(estimators, *[, …])`: Prediction voting regressor for unfitted estimators.
- `ensemble.HistGradientBoostingRegressor([…])`: Histogram-based Gradient Boosting Regression Tree.
- `ensemble.HistGradientBoostingClassifier([…])`: Histogram-based Gradient Boosting Classification Tree.

> ### 2.9 sklearn.cluster聚类

> ### 2.10 sklearn.naive_bayes

> ## 3. 梯度下降 gradient_descent

```Python
def gradient_descent(x,y):
    m_curr = b_curr = 0
    iterations = 1000000
    n = len(x)
    learning_rate = 0.0002

    # cost_previous = 0

    for i in range(iterations):
        y_predicted = m_curr * x + b_curr
        # cost = (1/n)*sum([value**2 for value in (y-y_predicted)])
        md = -(2/n)*sum(x*(y-y_predicted))
        bd = -(2/n)*sum(y-y_predicted)
        m_curr = m_curr - learning_rate * md
        b_curr = b_curr - learning_rate * bd
        # if math.isclose(cost, cost_previous, rel_tol=1e-20):
            # break # 下降太小
        cost_previous = cost
        print ("m {}, b {}, cost {}, iteration {}".format(m_curr,b_curr,cost, i))

    return m_curr, b_curr
```

> ## 4. pickle 

- `load`: 读取Model pickle.load(file, *, fix_imports=True, encoding="ASCII", errors="strict", buffers=None)
- `dump`: 保存Model pickle.dump(obj, file, protocol=None, *, fix_imports=True, buffer_callback=None)

> ## 5. Sigmoid

```Python
import math
def sigmoid(x):
  return 1 / (1 + math.exp(-x))
```